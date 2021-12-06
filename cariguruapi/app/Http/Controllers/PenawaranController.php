<?php

namespace App\Http\Controllers;

use App\Models\Penawaran;
use Illuminate\Http\Request;

class PenawaranController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $penawaran = Penawaran::all();
        $penawaran->load('user');
        $penawaran->load('guru');
        $response = [
            'message'=>'penambahan data sukses',
            'data' => $penawaran,
            'ok' => true
        ];
        return response()->json($response, 200);
    }

    public function indexid($id)
    {
        $penawaran = Penawaran::where('user_id', $id)->get();
        $penawaran->load('user');
        $penawaran->load('guru');

        $response = [
            'message'=>'penambahan data sukses',
            'data' => $penawaran,
            'ok' => true
        ];
        return response()->json($response, 200);
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
        $penawaran = Penawaran::create($request->all());
        $response = [
            'message'=>'penambahan data sukses',
            'data' => '',
            'ok' => true
        ];
        return response()->json($response, 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Penawaran  $penawaran
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $penawaran = Penawaran::with('user','guru')->find($id);

        $response = [
            'message'=>'pengambilan data sukses',
            'data' => $penawaran,
            'ok' => true
        ];
        return response()->json($response, 200);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Penawaran  $penawaran
     * @return \Illuminate\Http\Response
     */
    public function edit(Penawaran $penawaran)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Penawaran  $penawaran
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Penawaran $penawaran)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Penawaran  $penawaran
     * @return \Illuminate\Http\Response
     */
    public function destroy(Penawaran $penawaran)
    {
        //
    }
}
