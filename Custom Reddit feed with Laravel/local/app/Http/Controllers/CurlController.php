<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Goutte\Client;

use App\Http\Requests;
use App\Http\Controllers\Controller;

class CurlController extends Controller
{
    protected function redditText(Request $request)
    {   $data = $request->input();
        $client = new Client();
        $url = 'http://www.reddit.com/r/'.$data['url'];
        $crawler = $client->request('GET', $url);
        $client->getClient()->setDefaultOption('config/curl/'.CURLOPT_TIMEOUT, 60);
        echo '<ul class="list-group">';
        $crawler->filter('a.title')->each(function ($node) {
            if ($node->text() != 'Please copy/paste the relevant text from your source in the comments (+ a note on verifiable titles)'){
                echo '<a href="'.$node->attr('href').'" target="_blank">';
                echo '<li class="list-group-item" style="color:black;">' . $node->text() . '</li>';
                echo '</a>';
            }
        });
        echo '</ul>';
    }
    protected function redditImages(Request $request)
    {   $data = $request->input();
        $client = new Client();
        $url = 'http://www.reddit.com/r/'.$data['url'];
        $crawler = $client->request('GET', $url);
        $client->getClient()->setDefaultOption('config/curl/'.CURLOPT_TIMEOUT, 60);
        $crawler->filter('.entry')->each(function ($node) {
            echo '<div class="row"><div class="col-md-12">';
            $node->filter('.comments')->each(function ($commentNode) {
                echo '<a  href="'.$commentNode->attr('href').'" target="_blank">';
            });
            $node->filter('.title > a.title')->each(function ($titleNode) {
                if ($titleNode->text() != 'Please copy/paste the relevant text from your source in the comments (+ a note on verifiable titles)'){
                    echo '<h3>'.$titleNode->text().'</h3></a><hr/>';
                    echo '<img src="'.$titleNode->attr('href').'.gif" class="img-responsive"/>';
                }
            });
            echo '</div></div>';
        });
    }
}
