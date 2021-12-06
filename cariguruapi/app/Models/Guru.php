<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Guru extends Model
{
    protected $table = "gurus";

    public function penawaran()
    {
        return $this->hasMany(Penawaran::class);
    }
}
