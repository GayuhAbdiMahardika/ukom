<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class AuthController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    public function auth(Request $request)
    {
        $user = User::where('email', $request->email)->first();
        if($user){
            if(Hash::check($request->password, $user->password)){
                $response = [
                    'message'=>'login berhasil',
                    'data' => $user,
                    'ok' => true
                ];
                if($user->role == 1){
                    $user->load('guru');
                } else if($user->role == 2){
                    $user->load('siswa');
                }
                return response()->json($response, 200);
            }
            $response = [
                'message'=>'login gagal',
                'data' => '',
                'ok' => false
            ];
            return response()->json($response, 404);
        }
        $response = [
            'message'=>'login gagal',
            'data' => '',
            'ok' => false
        ];
        return response()->json($response, 404);
    }

    public function logout()
    {
        // Auth::logout();
        $response = [
            'message'=>'logout berhasil',
            'data' => '',
            'ok' => true
        ];
        return response()->json($response, 404);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
