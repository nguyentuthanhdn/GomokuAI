package com.company;

public interface ExplorationPolicy {
    /**
     * The method chooses an action depending on the provided estimates. the
     * estimates can be any sort of estimate, which values usefulness of the action
     * (expected summary reward, discounted reward, etc).
     *
     * @param actionEstimates Action estimates.
     * @return Returns selected action.
     */
    void ChooseAction(double[][] actionEstimates);
}
