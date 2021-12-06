<?php

namespace App\Http\Controllers;

use App\Models\Guru;
use App\Models\Siswa;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        
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
        $request->validate([
            'nama' => 'required',
            'email' => 'required|email',
            'password' => 'required|min:6',
        ]);
        // $response = [
        //     'message'=>'register gagal',
        //     'data' => '',
        //     'ok' => false
        // ];
        // return response()->json($response, 404);
        $user = new User();
        $user->email = $request->email;
        $user->role = $request->role;
        $user->password = Hash::make($request->password);
        $user->save();

        if($request->role == 1){
            $guru = new Guru();
            $guru->user_id = $user->id;
            $guru->nama = $request->nama;
            $guru->provinsi = $request->provinsi;
            $guru->kabupaten = $request->kabupaten;
            $guru->alamat_lengkap = $request->alamat_lengkap;
            $guru->tanggal_lahir = $request->tanggal_lahir;
            $guru->pendidikan_terakhir = $request->pendidikan_terakhir;
            $guru->keahlian = $request->keahlian;
            $guru->whatsapp = $request->whatsapp;
            $guru->no_rek = $request->no_rek;
            $guru->gender = $request->gender;

            $user->save();
            $guru->save();

            $response = [
                'message'=>'register sukses',
                'data' => '',
                'ok' => true
            ];
            return response()->json($response, 404);
        }
        if($request->role == 2){
            $siswa = new Siswa();
            $siswa->user_id = $user->id;
            $siswa->nama = $request->nama;
            $siswa->provinsi = $request->provinsi;
            $siswa->kabupaten = $request->kabupaten;
            $siswa->alamat_lengkap = $request->alamat_lengkap;
            $siswa->tanggal_lahir = $request->tanggal_lahir;
            $siswa->whatsapp = $request->whatsapp;
            $siswa->gender = $request->gender;

            $user->save();
            $siswa->save();

            $response = [
                'message'=>'register sukses',
                'data' => '',
                'ok' => true
            ];
            return response()->json($response, 404);
        }

        $response = [
            'message'=>'register gagal',
            'data' => '',
            'ok' => false
        ];
        return response()->json($response, 404);


    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function show(User $user)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function edit(User $user)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, User $user)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\User  $user
     * @return \Illuminate\Http\Response
     */
    public function destroy(User $user)
    {
        //
    }
}
