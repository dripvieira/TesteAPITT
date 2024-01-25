package com.titan.software.common;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Hamcrest {
    @Test
    void assertionsHamcrest(){
        // acrescentar "static" e ".*" em "import org.hamcrest.Matchers;" exclui a necessidade de passar o comando Matchers no método
        //is() representa igualdade
        assertThat("Adriano", is("Adriano"));
        assertThat(41, is(41));

        //isA(String) -> valida de pertence ao tipo de dado (string, inteiro, caractere etc...)
        assertThat(42, isA(Integer.class));


        //lessThan(valor) -> Verifica se o valor atual (27) é menor que o esperado (25)
        assertThat(24, lessThan(25));

        //lessThan(valor) -> Verifica se o valor atual (42) é maior que o esperado (18)
        assertThat(42, greaterThan(18));

        // Trabalhando com listas
        List <Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // hasSize (tamanhao) -> Valida o tamanho da lista.
        assertThat(numeros, hasSize(10));

        // conteins(Lista) -> Valida se a lista está como esperado
        assertThat(numeros, contains(1,2,3,4,5,6,7,8,9,10));

        //containsInAnyOrder(Lista) -> Valida se os valores existem na lista, não se preocupa com a ordem.
        assertThat(numeros, containsInAnyOrder(5,4,3,2,1,6,7,8,9,10));
        // hasItem(Item) -> Valida se o item existe na lista
        assertThat(numeros, hasItem(3));


        // hasItems(Itens) -> Valida se os itens existem na lista
        assertThat(numeros, hasItems(9,2,6));


        //is(not(valor)) ou not(valor) -> Valida se o resultado atual não é igual ao esperado
        assertThat( "Adriano", is(not("Dri")));

        //anyOf(Matchers) -> Valida se o valor atual é igual a um ou outros valores
        assertThat("Adriano", anyOf(is("Dri"), is("Adriano")));


        //allOf(Matchers)
        assertThat("Adriano",allOf(
                startsWithIgnoringCase("ad"),
                containsString("ria"),
                endsWith("no"),
                endsWithIgnoringCase("NO")
        ));
    }
}
