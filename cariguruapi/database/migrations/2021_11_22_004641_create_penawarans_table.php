<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePenawaransTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('penawarans', function (Blueprint $table) {
            $table->id();
            $table->bigInteger('user_id')->nullable()->unsigned();
            $table->string('judul');
            $table->string('mapel');
            $table->string('jenjang');
            $table->integer('jumlah_pertemuan');
            $table->integer('menit_per_pertemuan');
            $table->integer('harga_asli');
            $table->integer('diskon');
            $table->foreign('user_id','user_id1')->references('id')->on('users');
            $table->foreign('user_id','user_id2')->references('user_id')->on('gurus');
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
        Schema::dropIfExists('penawarans');
    }
}
