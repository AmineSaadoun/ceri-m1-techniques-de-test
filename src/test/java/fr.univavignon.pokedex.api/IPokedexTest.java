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

        assertEquals("nimportqoi", pokemonNew.getName());

    }






}