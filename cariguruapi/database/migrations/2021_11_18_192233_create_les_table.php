<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateLesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('les', function (Blueprint $table) {
            $table->id();
            $table->bigInteger('siswa_id')->nullable()->unsigned();
            $table->bigInteger('guru_id')->nullable()->unsigned();
            $table->string('judul_les');
            $table->bigInteger('harga');
            $table->date('tanggal_mulai');
            $table->string('hari');
            $table->integer('jumlah_pertemuan');
            $table->string('jam_mulai');
            $table->string('mapel');
            $table->integer('durasi');
            $table->string('kabupaten');
            $table->string('provinsi');
            $table->string('alamat_lengkap');
            $table->integer('status');
            $table->foreign('siswa_id')->references('id')->on('users')->onUpdate('cascade');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('les');
    }
}
