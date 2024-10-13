package com.example.srodenas.simulacioncrud.Logic.interfaces

import com.example.srodenas.simulacioncrud.Logic.Client

interface OperationsInterface {
    fun ClientAdd ( id: Int, name: String, apellido : String, telefono : String )
    fun ClientDel ( id: Int)
    fun ClientUpdate ( id: Int, name: String, apellido : String, telefono : String)
}
