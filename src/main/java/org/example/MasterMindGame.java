package org.example;

import java.util.List;

public class MasterMindGame {

    public int[] evaluate(List<String> secret, List<String> suppositions) throws NotValidEntryException {
        int[] response = new int[2];
        int countWellPlaced = 0;
        int countMisplaced = 0;
        int index = 0;

        if ((secret == null || secret.isEmpty()) || (suppositions == null || suppositions.isEmpty())) {
            throw new NotValidEntryException("the list of secrets and suppositions must contain values");
        }

        if (secret.size() != suppositions.size()) {
            return new int[]{-1, -1};
        }

        for (String supposition : suppositions) {

            if (secret.contains(supposition)) {
                var color = secret.get(index);
                if (color.equals(supposition)) {
                    countWellPlaced++;
                } else {
                    countMisplaced++;
                }
            }
            index++;

        }
        response[0] = countWellPlaced;
        response[1] = countMisplaced;

        return response;

    }
}
