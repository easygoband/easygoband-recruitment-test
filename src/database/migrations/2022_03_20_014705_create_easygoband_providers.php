<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('easygoband_providers', function (Blueprint $table) {
            $table->id();
            $table->string('access_group_name',100);
            $table->integer('access_group_id');
            $table->integer('total_uses');
            $table->integer('event_id');
            $table->boolean('structure_decode');
            $table->string('name',100);
            $table->timestamp('modified');
            $table->integer('id_remote');
            $table->integer('basic_product_id');
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
        Schema::dropIfExists('easygoband_providers');
    }
};
