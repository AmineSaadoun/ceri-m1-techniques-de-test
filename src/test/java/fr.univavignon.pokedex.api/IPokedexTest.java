package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokedexTest {
    private IPokedex iPokedex;
    List<Pokemon> pokemons;
    @BeforeAll
    public void setUp() {
        // mock pour l'interface IPokedex
        this.iPokedex = mock(IPokedex.class);


        //Une liste de pokemons
        pokemons = Arrays.asList(
                new Pokemon(0,
                        "Bulbizarre", 130, 130,
                        100, 613, 64,
                        4000, 4, 0.91),

                new Pokemon(133, "Aquali", 186,
                        168, 260, 2729, 202
                        , 5000, 4, 0.91),
                new Pokemon(1,
                        "hamid", 190, 120,
                        434, 302, 45,
                        2000, 4, 0.80)
        );
    }


    @Test
    public void sizeTest() {
        when(this.iPokedex.size()).thenReturn(151);
        assertNotEquals(134, this.iPokedex.size());
    }
    @Test
    void addPokeTest() throws PokedexException {
        Pokemon pokemon = new Pokemon(5,
                "karazay", 349, 134,
                79, 640, 64,
                4302, 2, 0.32);
        when(this.iPokedex.addPokemon(pokemon)).thenReturn(3);
        int index = this.iPokedex.addPokemon(pokemon);
        when(this.iPokedex.getPokemon(index)).thenReturn(pokemon);
        Pokemon pokemonNew = this.iPokedex.getPokemon(index);

        assertEquals("karazay", pokemonNew.getName());
        assertEquals(2, pokemonNew.getCandy());

        assertNotEquals(80, pokemonNew.getCp());


    }



    @Test
    void pokemonClassTest() throws PokedexException {
        when(this.iPokedex.getPokemon(133)).thenReturn(new Pokemon(133, "Aquali", 186,
                168, 260, 2729, 202
                , 5000, 4, 0.91));


        Pokemon pokemon = this.iPokedex.getPokemon(133);

        assertEquals("Aquali", pokemon.getName());
        assertEquals(Pokemon.class, pokemon.getClass());

    }
    @Test
    public void pokeSortedByNameTest() {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 0.91),
                new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91),
                new Pokemon(1,
                        "hmaid", 1430, 120, 110, 654, 54, 3000, 4, 0.70),
                new Pokemon(3,
                        "yarawkan", 145, 128, 97, 514, 64, 2094, 5, 0.87)
        );

        when(iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);

        List<Pokemon> sortedPokemons = iPokedex.getPokemons(PokemonComparators.NAME);

        assertThrows(UnsupportedOperationException.class, () -> {
            sortedPokemons.add(new Pokemon(8, "hakuna", 124, 100, 65, 316, 76, 2000, 5, 0.81));
        });

        assertEquals("Aquali", sortedPokemons.get(0).getName());
        assertEquals("Bulbizarre", sortedPokemons.get(1).getName());
        assertEquals("hmaid", sortedPokemons.get(2).getName());
        assertEquals("yarawkan", sortedPokemons.get(3).getName());
    }

    @Test
    void getPokemon() {
        when(this.iPokedex.getPokemons()).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons();
        assertNotNull(pokemons);

        assertEquals(6, pokemons.size());
        try{
            pokemons.add(new Pokemon(4,
                    "Ana", 135, 234, 56, 345, 64, 3000, 3, 0.85));
            fail("On peut pas modifier la liste ");
        } catch (UnsupportedOperationException e) {
        }
    }






}