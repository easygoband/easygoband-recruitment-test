<?php

use App\Http\Controllers\HomeController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});


Route::prefix('providers')->group(function () {

    Route::delete('/delete',
        [HomeController::class, 'delete_provider']
    )->name('providers.delete');

    Route::put('/update',
        [HomeController::class, 'create_update_provider']
    )->name('providers.update');

    Route::post('/create',
        [HomeController::class, 'create_update_provider']
    )->name('providers.create');

    Route::get('/read',
        [HomeController::class, 'read_provider']
    )->name('providers.read');

});
