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
        $crawler->filter('.title > a.title')->each(function ($node) {
            echo '<div class="row">';
            if ($node->text() != 'Please copy/paste the relevant text from your source in the comments (+ a note on verifiable titles)'){
                echo '<div class="col-md-12">';
                echo '<img src="'.$node->attr('href').'.gif" class="img-responsive"/>';
                echo '<label>'.$node->text().'</label>';
                echo '</div>';
            }
            echo '</div>';
        });
    }
    protected function redditTextAndImage()
    {$data = $request->input();

    }
}
