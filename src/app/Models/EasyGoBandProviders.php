<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class EasyGoBandProviders extends Model
{
    use HasFactory;

    protected $table = 'easygoband_providers';

    protected $fillable = [
        'access_group_name',
        'access_group_id',
        'total_uses',
        'event_id',
        'structure_decode',
        'name',
        'modified',
        'id_remote',
        'basic_product_id'
    ];

    public function session_providers()
    {
        return $this->hasMany(EasyGoBandSessions::class,'id','id');
    }
}
