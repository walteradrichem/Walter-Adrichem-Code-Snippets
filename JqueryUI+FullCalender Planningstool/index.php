<div class="row">
    <div class="col-md-8">
        <h1><?= __d('default', 'manage_work_per') ?>   
            <button onclick="toggleDelete();" type="button" class="btn btn-red btn-icon icon-left" id="delBtn">
                <i class="glyphicon glyphicon-remove"></i>
                Toggle Delete
            </button>
        </h1>
        <p>Sleep hier taken op de kalender. Werknemers kunnen hun voorkeur voor de dienst hiervoor zelf opgeven.</p>
    </div>
</div>
<hr/><div class="row">
    <div class="col-md-8">
        <div id="gifloader">
            <img src="<?= $this->webroot ?>img/ajax-loader.gif" >
        </div>
        <div class="alert alert-danger" id="delAlert" style="display:none;"><b>Let op verwijderen staat aan!</b></div>
        <div id="calendar"></div>
    </div>
    <div class="col-md-4" > 
        <div class="panel panel-primary" data-collapsed="0" >
            <div class="panel-heading">
                <div class="panel-title">
                    <h4><?= __d('default', 'choose') ?></h4>
                </div>
            </div>
            <div class="panel-body" >
                <div class="alert alert-info">
                    <p style=" font-weight: bold;"><i class="glyphicon glyphicon-question-sign" style="margin-right: 5px; "></i><?= __d('default', 'slide_to_active') ?></p>
                </div>
                <div id='external-events'>
                    <div class='fc-event eventHover custom_cal_object'><?= __d('default', 'Tandarts'); ?></div>
                    <div class='fc-event eventHover custom_cal_object'><?= __d('default', 'Assistent'); ?></div>
                    <div class='fc-event eventHover custom_cal_object'><?= __d('default', 'Oproepkracht'); ?></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    // set vars through PHP
    var locBoxes = new Array();
<?php foreach ($locIds as $id) { ?>
        locBoxes.push(<?= $id ?>);
    <?php
}
$tasks = array(
    '4' => 'Tandarts',
    '5' => 'Assistent',
    '6' => 'Oproepkracht',
);
$color = array(
    'absent' => '#d42020',
    'prefer_not' => '#fbc70e',
    'black' => '#000',
    'preference' => '#00a651',
);
?>
    var preffs = [
<?php
// Loop through workperiods and add events to javascript array
foreach ($workperiods as $workperiod) {
    if ($workperiod['PlanningCalendar']['task_id'] == 4) {
        $task = __d('default', 'Tandarts');
        $color = '#5BD455';
    } else if ($workperiod['PlanningCalendar']['task_id'] == 5) {
        $task = __d('default', 'Assistent');
        $color = '#7091FA';
    } else if ($workperiod['PlanningCalendar']['task_id'] == 6) {
        $task = __d('default', 'Oproepkracht');
        $color = '#F77979';
    }
    echo "{
        id: {$workperiod['PlanningCalendar']['id']},
        eventtype: 'workPeriod',
        location : '{$workperiod['Location']['id']}',
        title : '" . date('H:i', strtotime($workperiod['PlanningCalendar']['start_date'])) . " - " . date('H:i', strtotime($workperiod['PlanningCalendar']['end_date'])) . "',
        task : '{$task}',
        color: '{$color}',
        circles_id: '{$workperiod['PlanningCalendar']['circles_id']}',
        weight: {$workperiod['PlanningCalendar']['weight']},
        start: new Date('" . date('Y-m-d H:i:s', strtotime($workperiod['PlanningCalendar']['start_date'])) . "'),            
        end: new Date('" . date('Y-m-d H:i:s', strtotime($workperiod['PlanningCalendar']['end_date'])) . " '),
        allDay: 'Allday',
        className : 'exchange',
      },";
}
?>
    ];
</script>