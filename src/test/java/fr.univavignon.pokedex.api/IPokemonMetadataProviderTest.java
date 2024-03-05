package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;


public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws Exception {
        this.pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

    }


    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(this.pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133,
                "Aquali", 186, 168, 260));
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(133);

        assertEquals("Aquali", metadata.getName());
        assertEquals(133, metadata.getIndex());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());

    }
}
