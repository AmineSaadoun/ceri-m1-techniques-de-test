package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider iPokemonMetadataProvider;

    @BeforeAll
    public void setUp() {
        // Création d'une instance réelle de PokemonMetadataProviderImpl
        this.iPokemonMetadataProvider = new PokemonMetadataProviderImpl();
    }

    @Test
    public void retrieveMetadataForBulbizarre() throws PokedexException {
        // Vérifie que les métadonnées pour Bulbizarre sont correctes
        PokemonMetadata pokemonMetadata = this.iPokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
    }


    @Test
    public void retrieveMetadataThrowsExceptionForInvalidIndex() {
        // Vérifie que l'exception est lancée pour un index invalide (151)
        assertThrows(PokedexException.class, () -> {
            this.iPokemonMetadataProvider.getPokemonMetadata(151);
        });
    }

    @Test
    public void retrieveMetadataThrowsExceptionForNegativeIndex() {
        // Vérifie que l'exception est lancée pour un index négatif (-1)
        assertThrows(PokedexException.class, () -> {
            this.iPokemonMetadataProvider.getPokemonMetadata(-1);
        });
    }

    @Test
    public void retrieveMetadataThrowsExceptionWhenPokemonNotFound() {
        // Vérifie que l'exception est lancée lorsque le Pokémon n'est pas trouvé
        assertThrows(PokedexException.class, () -> {
            this.iPokemonMetadataProvider.getPokemonMetadata(10); // Un index qui n'existe pas dans la liste
        });
    }

    @Test
    public void retrieveMetadataThrowsExceptionForUnknownIndex() {
        // Vérifie que l'exception est lancée pour un index inconnu (par exemple 1000)
        assertThrows(PokedexException.class, () -> {
            this.iPokemonMetadataProvider.getPokemonMetadata(1000);
        });
    }
}
