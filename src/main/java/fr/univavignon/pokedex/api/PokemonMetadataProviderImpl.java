package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider{

    List<PokemonMetadata> pokemonsMetadata;

    public PokemonMetadataProviderImpl() {
        pokemonsMetadata = new ArrayList<>();
        pokemonsMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126,
                90));
        pokemonsMetadata.add(new PokemonMetadata(58, "Aziz", 56, 71,
                43));

    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index >= 151)
        {
            throw new PokedexException("Invalid index");
        }
        else
        {
            for (PokemonMetadata pokemonMetadata : pokemonsMetadata) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        throw new PokedexException("PokemonMetaData not found");
    }
}