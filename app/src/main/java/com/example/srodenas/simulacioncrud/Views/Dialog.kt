package com.example.srodenas.simulacioncrud.Views

import com.example.srodenas.simulacioncrud.Data.RepositoryClient
import com.example.srodenas.simulacioncrud.Logic.Client
import com.example.srodenas.simulacioncrud.Logic.Controller
import com.example.srodenas.simulacioncrud.Logic.interfaces.OperationsInterface
import com.google.android.material.animation.AnimatableView.Listener
import kotlin.random.Random

//simulo un diálogo.
class Dialog {
    private var listener: OperationsInterface? = null  //Ya si eso lo creo.

    private var action : Int = 0

    private var myListClient: MutableList<Client>  //eso realmente, no se declararía aquí. Esto es interfaz.

    init{
        myListClient = RepositoryClient.arrayClient.toMutableList()
    }

    //Carga el listener para el botón
    fun setListener ( _listener : OperationsInterface){
        listener = _listener

    }

    //muestra el dialogo
    fun show(typeAction : Int){
        listener?.let{
            val posibleName = "CAMBIADO"
            var posibleId = -1
            if (myListClient.size != 0 ) {
                posibleId = Random.nextInt(0, myListClient.size)//me da un aleatorio. -1 está vacío para editar/borrar.
            }
            when (typeAction){
                0 -> onAccept() //simulamos que ahora pulsamos el botón aceptar de un nuevo

                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, "CAMBIADO", "CAMBIADO", "CAMBIADO")

                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }

        }
    }

    private fun onDelete(id : Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name : String, apellido:String, telefono:String) {
        listener!!.ClientUpdate(id, name, apellido, telefono)
    }

    //simula el pulsado del botón aceptar del dialogo. Este recoge los datos del usuario.
    private fun onAccept() {
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "APELLIDO", "TELEFONO")
    }
}