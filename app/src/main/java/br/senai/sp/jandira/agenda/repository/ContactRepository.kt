package br.senai.sp.jandira.agenda.repository

import android.content.Context
import br.senai.sp.jandira.agenda.dao.ContactDB
import br.senai.sp.jandira.agenda.model.Contact

class ContactRepository(context: Context) {

    private val db = ContactDB
                    .getDataBase(context)
                    .contactDAO()

    // Método para salvar um novo contato, que retorna a quantidade de contatos criados
    fun save(contact: Contact): Long {
        return db.save(contact)
    }

    // Método para atualizar um contato, que retorna a quantidade de contatos atualizados
    fun update(contact: Contact): Int {
        return db.update(contact)
    }

    // Método para deletar um contato, que retorna a quantidade de contatos excluídos
    fun delete(contact: Contact): Int {
        return db.delete(contact)
    }

    // Método que solicita a lista de contatos do banco, que retorna uma lista com eles
    fun getAll(): List<Contact> {
        return db.getAll()
    }

    // método que solicita um contato expecífico, a partir do ID do registro, que retorna o contato requerido
     fun getContactByID(id: Int): Contact {
         return db.getContactByID(id)
     }
}