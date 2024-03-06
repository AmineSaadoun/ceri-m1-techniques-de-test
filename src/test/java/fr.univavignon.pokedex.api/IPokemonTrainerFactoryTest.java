package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestInstance;

        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertThrows;
        import static org.junit.jupiter.api.Assertions.assertNotNull;
        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @BeforeAll
    public void setUp(){
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    }


    @Test
    public void testCreatePokemonTrainer() {
        Team team = Team.INSTINCT;
        String trainer = "Ash";

        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        when(pokemonTrainerFactory.createTrainer(trainer, team, pokedexFactory))
                .thenReturn(new PokemonTrainer(trainer, team, pokedex));

        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainer, team, pokedexFactory);

        assertNotNull(pokemonTrainer);
        assertEquals("Ash", pokemonTrainer.getName());
        assertEquals(team, pokemonTrainer.getTeam());
    }
    @Test
    public void createWithNullParamsTest() {
        Team team = Team.INSTINCT;
        //trainer
        String trainer = "Ash";
        //pokedexFactory

        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        //pokedex
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        //trainer
        when(pokemonTrainerFactory.createTrainer(null, team, pokedexFactory)).thenThrow(new IllegalArgumentException());
        when(pokemonTrainerFactory.createTrainer(trainer, null, pokedexFactory)).thenThrow(new IllegalArgumentException());
        when(pokemonTrainerFactory.createTrainer(trainer, team, null)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer(null, team, pokedexFactory));
        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer("Ash", null, pokedexFactory));
        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer("Ash", team, null));
    }


}