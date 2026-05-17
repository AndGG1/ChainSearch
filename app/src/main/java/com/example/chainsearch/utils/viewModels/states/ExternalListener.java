package com.example.chainsearch.utils.viewModels.states;

import java.util.List;

public record ExternalListener(
        boolean hasInternetConnection, List<String> perms, boolean hasStorage) {
    //empty
}
