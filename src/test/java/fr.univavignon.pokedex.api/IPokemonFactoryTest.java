package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;


public class IPokemonFactoryTest{
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        //bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //this.pokemonFactory = mock(IPokemonFactory.class);
        this.pokemonFactory = new PokemonFactory();

    }

    @Test
    public void testCreatePokemon() {
        IPokemonFactory iPokemonFactoryMock = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(iPokemonFactoryMock.createPokemon(anyInt(),eq(613),eq(64),eq(4000),eq(4))).thenAnswer(input -> {

                    if((int)input.getArgument(0) < 0 || (int)input.getArgument(0) > 150){
                        throw new PokedexException("Index must be between 0 and 150!");
                    }
                    return pokemon;
                }
        );
        assertThrows(PokedexException.class,()->iPokemonFactoryMock.createPokemon(-1,613,64,4000,4));
        assertThrows(PokedexException.class,()->iPokemonFactoryMock.createPokemon(151,613,64,4000,4));
        assertEquals(pokemon, iPokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4));
    }
    @Test
    public void testCreatePokemonShouldReturnCorrectPokemon() throws PokedexException {
        Pokemon pokemon = this.pokemonFactory.createPokemon(0, 614, 70,
                4000, 5);

        assertEquals(614, pokemon.getCp());
        assertEquals(70, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(0, pokemon.getIndex());

        assertEquals(5, pokemon.getCandy()); }

}