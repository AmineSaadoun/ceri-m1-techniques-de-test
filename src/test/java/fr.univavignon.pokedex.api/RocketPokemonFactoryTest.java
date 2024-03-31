package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RocketPokemonFactoryTest {
    IPokemonFactory pokemonFactory = new RocketPokemonFactory();
    @BeforeEach
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void pokemonNullWhenCombatLvlNegativeTest() {

        assertNotNull(this.pokemonFactory.createPokemon(0, -1, 0, 0, 0));
    }

    @Test
    public void pokemonNullWhenDustNegativeTest() {
        assertNotNull(this.pokemonFactory.createPokemon(0, 0, 0, -1, 0));
    }

    @Test
    public void pokemonNullWhenHealthPointsNegativeTest() {
        assertNotNull(this.pokemonFactory.createPokemon(0, 0, -1, 0, 0));
    }

    @Test
    public void pokemonNullWhenCandiesAmountNegativeTest() {
        assertNotNull(this.pokemonFactory.createPokemon(0, 0, 0, 0, -1));
    }

    @Test
    public void pokemonNullWhenIndexNegativeTest() {
        assertNotNull(this.pokemonFactory.createPokemon(-1, 0, 0, 0, 0));
    }

    @Test
    public void pokemonNullWhenIndexGreaterThan150Test() {
        assertNotNull(this.pokemonFactory.createPokemon(151, 0, 0, 0, 0));
    }

    @Test
    public void testPokemonCorrectlyCreated() {
        int index = 0;
        int cp = 10;
        int hp = 40;
        int dust = 20;
        int candy = 2;
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertNotEquals(0, pokemon.getIv());
    }
}