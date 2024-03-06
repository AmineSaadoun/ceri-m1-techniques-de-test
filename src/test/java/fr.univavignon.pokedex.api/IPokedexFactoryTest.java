package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    @Before
    public void setUp() {
        this.pokedexFactory = mock(IPokedexFactory.class);
        this.pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        this.pokemonFactory = mock(IPokemonFactory.class);
    }
    @Test
    public void createPokedexTest() {
        when(this.pokedexFactory.createPokedex(this.pokemonMetadataProvider, this.pokemonFactory)).
                thenReturn(mock(IPokedex.class));
        IPokedex iPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertEquals(null, iPokedex);
    }

}
