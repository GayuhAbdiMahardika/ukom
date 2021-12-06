<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateGurusTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('gurus', function (Blueprint $table) {
            $table->id();
            $table->bigInteger('user_id')->nullable()->unsigned();;
            $table->date('membership_berakhir')->nullable();
            $table->string('nama');
            $table->string('gambar')->nullable();
            $table->string('provinsi');
            $table->string('kabupaten');
            $table->string('alamat_lengkap');
            $table->string('tanggal_lahir');
            $table->string('pendidikan_terakhir');
            $table->string('keahlian');
            $table->string('foto_ijazah')->nullable();
            $table->string('foto_ktp')->nullable();
            $table->string('foto_selfie_ktp')->nullable();
            $table->string('instagram')->nullable();
            $table->string('facebook')->nullable();
            $table->string('whatsapp')->nullable();
            $table->string('no_rek')->nullable();
            $table->string('gender');
            $table->foreign('user_id')->references('id')->on('users')->onUpdate('cascade');
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
        Schema::dropIfExists('gurus');
    }
}
