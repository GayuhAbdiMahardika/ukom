<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Penawaran extends Model
{
    protected $table = 'penawarans';
    protected $fillable =['user_id','jenjang','judul','mapel','harga_asli', 'jumlah_pertemuan','menit_per_pertemuan','harga_asli','diskon'];

    public function user()
    {
        return $this->belongsTo(User::class);
    }

    public function guru()
    {
        return $this->belongsTo(Guru::class, 'user_id', 'user_id');
    }
}
