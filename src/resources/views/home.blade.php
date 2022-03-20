@extends('layout.app')
@section('content')
    <h1 class="mt-4">Home</h1>
    <div class="row">
        @if( isset( $providers) && is_object( $providers )  && !empty( $providers ) )
            @foreach( $providers as $provider)
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-header">
                            <strong>ID:{{ $provider->id }}</strong> {{ $provider->name }}
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xs-4">
                                    <strong>Event ID:</strong> {{ $provider->event_id }}
                                </div>
                                <div class="col-xs-4">
                                    <strong>Access Group Name:</strong> {{ $provider->access_group_name }}
                                </div>
                                <div class="col-xs-4">
                                    <strong>Total Users:</strong> {{ $provider->total_uses }}
                                </div>
                            </div>
                            <br>
                            @if( isset( $provider->session_providers) && is_object( $provider->session_providers ) && !empty( $provider->session_providers ) )
                                <ol>
                                    @foreach( $provider->session_providers as $session)
                                        <li> {{ $session->name }} </li>
                                    @endforeach
                                </ol>
                            @endif
                        </div>
                        <div class="card-footer" style="text-align: right;">
                            <button class="btn btn-danger btn-delete-item" data-id-provider="{{ $provider->id }}">
                                <i class="fas fa-times" aria-hidden="true"></i>
                                Borrar
                            </button>
                        </div>
                    </div>
                </div>
            @endforeach
        @endif
    </div>
@endsection
@section('script')
    <script>
        $(document).ready( function(){

            $(document).on('click', '.btn-delete-item',function() {

                let btn = $(this);

                if( confirm('¿Quieres borrar el proveedor?') )
                {
                    let data = btn.data();

                    $.ajax({
                        url: "{{ route('providers.delete') }}",
                        method: "DELETE",
                        data: data,
                        beforeSend: function(){
                            btn.prop('disabled', true);
                        },
                        complete:function (){
                            btn.prop('disabled', false);
                        },
                        success:function (){
                            alert('Proveedor borrado correctamente');
                            window.location.href = "{{ route('home') }}";
                        },
                        error:function (){
                            alert("No se pudo borrar el proveedor, intentalo mas tarde")
                        }
                    });
                }

            });

        } );
    </script>
@endsection
