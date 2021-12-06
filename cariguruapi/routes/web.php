<?php

/** @var \Laravel\Lumen\Routing\Router $router */

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});

$router->group([], function() use ($router) {
    
    $router->get('/logout', 'AuthController@logout');
    $router->post('/auth', 'AuthController@auth');

    $router->post('/register', 'UserController@store');
    $router->post('/penawaran', 'PenawaranController@store');
    $router->get('/penawaran/guru/{id}', 'PenawaranController@indexid');
    $router->get('/penawaran', 'PenawaranController@index');
    $router->get('/penawaran/{id}', 'PenawaranController@show');

});

// $router->get('/logout', 'AuthController@logout');
