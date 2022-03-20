<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class EasyGoBandSessions extends Model
{
    use HasFactory;

    protected $table = 'easygoband_sessions';

    protected $fillable = [
        'id_remote',
        'id_provider',
        'name',
    ];
}
