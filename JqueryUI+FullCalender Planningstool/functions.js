    var shiftStart;
    var shiftEnd;
    var webroot;
    var deleteactive = false;
    var copiedEventObject;
    var calender = $('#calendar');
    $(document).ready(function () {
        $('#external-events .fc-event').each(function () {
            if ($(this).text() === 'Tandarts') {
                var eventObject = {
                    title: $.trim($(this).text()),
                    eventtype: 'workPeriod',
                    allDay: true,
                    className: 'exchange',
                    task_id: 4,
                    color: '#5BD455'
                };
            } else if ($(this).text() === 'Assistent') {
                var eventObject = {
                    title: $.trim($(this).text()),
                    eventtype: '2',
                    allDay: true,
                    className: 'exchange',
                    task_id: 5,
                    color: '#7091FA'
                };
            } else if ($(this).text() === 'Oproepkracht') {
                var eventObject = {
                    title: $.trim($(this).text()),
                    eventtype: '3',
                    allDay: true,
                    className: 'exchange',
                    task_id: 6,
                    color: '#F77979'
                };
            }
            $(this).data('eventObject', eventObject);
            $(this).draggable({
                zIndex: 999,
                revert: true,
                revertDuration: 0
            });
        });
        calender.fullCalendar({
            defaultView: 'month',
            contentHeight: 450,
            weekNumbers: true,
            editable: true,
            droppable: true,
            eventClick: function (calEvent, jsEvent, view) {
                if (calEvent.eventtype == 'workPeriod') {
                    if (deleteactive) {
                        deleteEvent(calEvent.id);
                    }
                } else {
                    window.location.replace(wr + 'shift/edit/' + calEvent.id);
                }
            },
            drop: function (date, jsEvent) {
                var originalEventObject = $(this).data('eventObject');
                copiedEventObject = $.extend({}, originalEventObject);
                copiedEventObject.start = date;
                copiedEventObject.end = date;
                copiedEventObject.location = currentLoc;
                shiftStart = date;
                shiftEnd = date;
                addWorkperiod(copiedEventObject);
            },
            eventResize: function (event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) {
                shiftStart = event.start;
                shiftEnd = event.end;
                editWorkperiod(event.id);
            },
            eventDrop: function (event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {

                console.log(event.start);
                shiftStart = event.start;
                shiftEnd = event.end;
                editWorkperiod(event.id);
            },
            header: {
                left: '',
                center: 'title',
                right: 'month,agendaWeek,agendaDay today prev,next'
            },
            firstDay: 1,
            selectable: true,
            selectHelper: true,
            events: preffs,
        });
        refreshEvents(currentLoc);
    });

    function toggleDelete() {
        if (deleteactive) {
            deleteactive = false;
            $('#delBtn').css('background-color', '#D42020');
        } else {
            deleteactive = true;
            $('#delBtn').css('background-color', '#B11B1B');
        }
        $('#delAlert').toggle('fast');
    }

    function deleteEvent(id) {
        $.ajax({
            url: webroot +"/calendars/ajax_deleteWorkPeriod/" + id,
            cache: false
        }).done(function (preffs) {
            if (preffs != '0') {
                console.log(id);
                calender.fullCalendar('removeEvents', id);
            }
        });
        removeFromPreffs(id);
    }
    function removeFromPreffs(id) {
        for (var i = 0; i < preffs.length; i++) {
            if (preffs[i].id == id) {
                preffs.splice(i, 1);
                break;
            }
        }
    }
    function refreshEvents(value) {
        currentLoc = value;
        calender.fullCalendar('removeEventSource', preffs);
        calender.fullCalendar('addEventSource', preffs);
        calender.fullCalendar('removeEvents', function (event) {
            return event.location != value;
        });
    }
    function createDate(time, curDate) {
        var date = new Date(curDate);
        var year = date.getFullYear();
        var month = date.getMonth();
        month = parseInt(month) + 1;
        if (month < 10) {
            month = '0' + month;
        }
        var day = date.getDate();
        day = parseInt(day);

        if (day < 10) {
            day = '0' + day;
        }
        var dateString = day + '-' + month + '-' + year + ' ' + time,
                dateParts = dateString.split(' '),
                timeParts = dateParts[1].split(':'),
                date;
        dateParts = dateParts[0].split('-');

        date = new Date(dateParts[2], parseInt(dateParts[1], 10) - 1, dateParts[0], timeParts[0], timeParts[1]);

        return date;
    }
    function addWorkperiod() {
        $('#gifloader').show();
        var starttime = new Date(shiftStart);
        var endtime = new Date(shiftEnd);
        $.ajax({
            url: webroot + "/calendars/ajax_allowPlanningDates/",
            type: "POST",
            dataType: "json",
            data: {user_id: user_id, start: starttime, end: endtime, location: copiedEventObject.location, task: copiedEventObject.task_id},
        }).done(function (shift_id) {
            if (shift_id == '0') {
                alert('shift_not_saved');
            } else {
                copiedEventObject.id = shift_id;
                copiedEventObject.start = starttime;
                copiedEventObject.end = endtime;
                copiedEventObject.eventtype = 'workPeriod';
                calender.fullCalendar('renderEvent', copiedEventObject);
                preffs.push(copiedEventObject);
            }
        });
        $('#gifloader').hide();
    }
    function editWorkperiod(id) {
        $('#gifloader').show();
        var starttime = new Date(shiftStart);
        var endtime = new Date(shiftEnd);
        $.ajax({
            url: webroot +"/calendars/editDate/",
            type: "POST",
            dataType: "json",
            data: {id: id, start: starttime, end: endtime},
        });
        $('#gifloader').hide();
    }
