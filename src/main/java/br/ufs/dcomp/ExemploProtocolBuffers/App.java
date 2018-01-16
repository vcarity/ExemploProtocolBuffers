package br.ufs.dcomp.ExemploProtocolBuffers;

import br.ufs.dcomp.ExemploProtocolBuffers.AddressBookProtoBuf.AddressBook;
import br.ufs.dcomp.ExemploProtocolBuffers.AddressBookProtoBuf.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        Person.Builder person = Person.newBuilder();
        person.setId(1);
        person.setName("tarcisio");
        person.setEmail("tarcisio@dcomp.ufs.br");
        
        Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder();
        phoneNumber.setNumber("8711-3233");
        phoneNumber.setType(Person.PhoneType.MOBILE);
            
        person.addPhones(phoneNumber);
        
        //person.build(); não altera a classe principal, ele gera uma nova
        
        byte[] msg = person.build().toByteArray();
    
        Person personx = Person.parseFrom(msg);
    }
}
