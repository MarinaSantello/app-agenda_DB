package br.senai.sp.jandira.agenda.dao

import androidx.room.*
import br.senai.sp.jandira.agenda.model.Contact

// Anotação responsável por indicar que o ROOM deve gerenciar a classe como um DAO
@Dao
interface ContactDAO {

    // Anotação responsável por fazer o método 'save' retornar o id do contato gerado no banco (retorno importante para controle de sucesso da execução)
    @Insert
    fun save(contact: Contact): Long

    // Anotação responsável por fazer o método 'delete' retornar a quantidade de contatos deletados no banco (retorno importante para controle de sucesso da execução)
    @Delete
    fun delete(contact: Contact): Int

    // Anotação responsável por fazer o método 'update' retornar a quantidade de contatos atualizados no banco (retorno importante para controle de sucesso da execução)
    @Update
    fun update(contact: Contact): Int

    // Anotação responsável por fazer o método 'getAll' retornar uma lista com todos os contatos da tabela de contatos, em ordem alfabética
    @Query("select * from tbl_contact order by nome asc")
    fun getAll(): List<Contact>

    // Anotação responsável por fazer o método 'getContactByID' retornar um contato do banco
    @Query("SELECT * FROM tbl_contact WHERE id = :id") // ':id'- parâmetro que recebe informação do argumento do método 'getContactByID'
    fun getContactByID(id: Int): Contact
}