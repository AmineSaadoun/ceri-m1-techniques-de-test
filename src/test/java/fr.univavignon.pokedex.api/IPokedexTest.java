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
    private List<Pokemon> pokemons;

    @BeforeAll
    public void setUp() {
        this.iPokedex = mock(IPokedex.class);

        pokemons = Arrays.asList(
                new Pokemon(0,
                        "Bulbizarre", 130, 130,
                        100, 613, 64,
                        4000, 4, 0.91),
                new Pokemon(1,
                        "Herbizarre", 160, 158,
                        120, 613, 64,
                        4000, 4, 0.91),
                new Pokemon(2,
                        "Florizarre", 198, 200,
                        160, 613, 64,
                        4000, 4, 0.91),
                new Pokemon(133, "Aquali", 186,
                        168, 260, 2729, 202
                        , 5000, 4, 0.91)
        );
    }

    @Test
    public void getAGoodSize() {
        when(this.iPokedex.size()).thenReturn(151);
        assertEquals(151, this.iPokedex.size());
    }

    @Test
    void addPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(3,
                "Salamèche", 128, 108,
                78, 613, 64,
                4000, 4, 0.91);
        when(this.iPokedex.addPokemon(pokemon)).thenReturn(3);

        int index = this.iPokedex.addPokemon(pokemon);
        when(this.iPokedex.getPokemon(index)).thenReturn(pokemon);
        Pokemon pokemonAdded = this.iPokedex.getPokemon(index);
        assertEquals("Salamèche", pokemonAdded.getName());
    }

    @Test
    void getPokemon() throws PokedexException {
        when(this.iPokedex.getPokemon(0)).thenReturn(new Pokemon(0,
                "Bulbizarre", 130, 130,
                100, 613, 64,
                4000, 4, 0.91));
        Pokemon pokemon = this.iPokedex.getPokemon(0);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(Pokemon.class, pokemon.getClass());
    }

    @Test
    public void testGetPokemonThrowsPokedexException() throws PokedexException {
        when(this.iPokedex.getPokemon(151)).thenThrow(new PokedexException("Pokemon not found"));
        assertThrows(PokedexException.class, () -> {
            this.iPokedex.getPokemon(151);
        });
    }

    @Test
    void getPokemons() {
        when(this.iPokedex.getPokemons()).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(4, pokemons.size());
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(3,
                    "Salamèche", 128, 108,
                    78, 613, 64,
                    4000, 4, 0.91));
        });
        assertEquals(4, pokemons.size());
    }

    @Test
    void testGetPokemonsFiltredByName() {
        when(this.iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons(PokemonComparators.NAME);
        assertNotNull(pokemons);
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(3,
                    "Salamèche", 128, 108,
                    78, 613, 64,
                    4000, 4, 0.91));
        });
        assertEquals("Aquali", pokemons.get(0).getName());
    }

    @Test
    public void getPokemonsFiltredByIndex() {
        when(this.iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons(PokemonComparators.INDEX);
        assertNotNull(pokemons);
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(3,
                    "Salamèche", 128, 108,
                    78, 613, 64,
                    4000, 4, 0.91));
        });
        assertEquals("Aquali", pokemons.get(pokemons.size() - 1).getName());
    }

    @Test
    public void getPokemonsFiltredByCP() {
        when(this.iPokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons(PokemonComparators.CP);
        assertNotNull(pokemons);
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(3,
                    "Salamèche", 128, 108,
                    78, 613, 64,
                    4000, 4, 0.91));
        });
        assertEquals("Aquali", pokemons.get(pokemons.size() - 1).getName());
    }

    @Test
    void createPokemonTest() throws PokedexException {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.91));

        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        IPokedex pokedex = new PokedexImplement(pokemonFactory, pokemonMetadataProvider);

        Pokemon createdPokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);

        assertEquals("Bulbasaur", createdPokemon.getName());
        assertEquals(126, createdPokemon.getAttack());
        assertEquals(126, createdPokemon.getDefense());
        assertEquals(90, createdPokemon.getStamina());
    }

    @Test
    void getPokemonMetadataTest() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        IPokedex pokedex = new PokedexImplement(pokemonFactory, pokemonMetadataProvider);
    }
    @Test
    void testPokemonsNoModifiableGet() {
        IPokedex pokedex = new PokedexImplement();

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(2, "Amine", 190, 201, 140, 610, 60, 4000, 4, 0.91));
        });
    }
}
