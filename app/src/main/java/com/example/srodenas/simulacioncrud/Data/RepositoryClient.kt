package com.example.srodenas.simulacioncrud.Data

import com.example.srodenas.simulacioncrud.Logic.Client


class RepositoryClient {

    companion object {  //Sólo puedo tener un companion object por clase.
        var primary = 0

        val arrayClient : List<Client> = listOf (
            Client (RepositoryClient.incrementPrimary(), "Santi", "Rodenas", "123456"),
            Client (RepositoryClient.incrementPrimary(), "Daniel", "Romero", "789012"),
            Client (RepositoryClient.incrementPrimary(), "David", "Muñoz", "345678"),
            Client (RepositoryClient.incrementPrimary(), "Alejandro", "Copado", "901234")
        )

        fun incrementPrimary() = primary ++ //devuelvo la clave e incremento.
    }

}
//Ya tengo mi Lista inmutable de Clientes.

/*
Importante, ver que si declaro una clase terminado en (), lo que quiero decir que la voy a
instanciar ya que sería el constructor primario. Sin embargo, como no quiero objeto, no tiene sentido
declarala con un constructor por defecto, ni bloque ini, ni nada.
 */
