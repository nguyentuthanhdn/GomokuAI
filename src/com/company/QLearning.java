package com.company;

import java.util.Random;

//TODO Refer to this resource for creating and finishing this class
// https://github.com/accord-net/java/blob/master/Catalano.MachineLearning/src/Catalano/MachineLearning/QLearning.java#L70
public class QLearning {
    // amount of possible states
    private int states;
    // amount of possible actions
    private int actions;
    // q-values
    private double[][] qValues;
    // exploration policy
    private ExplorationPolicy explorationPolicy;
    // discount factor
    /**
     * Discount factor for the expected summary reward. The value serves as
     * multiplier for the expected reward. So if the value is set to 1,
     * then the expected summary reward is not discounted. If the value is getting
     * smaller, then smaller amount of the expected reward is used for actions'
     * estimates update.
     *
     * @param discountFactor
     */
    private double discountFactor = 0.95;
    // learning rate
    //     * Learning rate, [0, 1].
    //     * The value determines the amount of updates Q-function receives
    //     * during learning. The greater the value, the more updates the function receives.
    //     * The lower the value, the less updates it receives.
    //     *
    private double learningRate = 0.25;

    /**
     * Initializes a new instance of the QLearning class.
     *
     * @param states            Amount of possible states.
     * @param actions           Amount of possible actions.
     * @param explorationPolicy Exploration policy.
     * @param randomize         Randomize action estimates or not.
     */
    public QLearning(int states, int actions, ExplorationPolicy explorationPolicy, boolean randomize) {
        this.states = states;
        this.actions = actions;
        this.explorationPolicy = explorationPolicy;
        // create Q-array
        qValues = new double[states][];
        for (int i = 0; i < states; i++) {
            qValues[i] = new double[actions];
        }

        if (randomize) {
            Random r = new Random();
            for (int i = 0; i < states; i++) {
                for (int j = 0; j < actions; j++) {
                    qValues[i][j] = r.nextDouble() / 10;
                }
            }
        }
    }

    public int getStates() {
        return states;
    }

    public int getActions() {
        return actions;
    }

    public ExplorationPolicy getExplorationPolicy() {
        return explorationPolicy;
    }

    public void setExplorationPolicy(ExplorationPolicy explorationPolicy) {
        this.explorationPolicy = explorationPolicy;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = Math.max(0.0, Math.min(1.0, learningRate));
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = Math.max(0.0, Math.min(1.0, discountFactor));
    }

    /**
     * Get next action from the specified state.
     *
     * @param state Current state to get an action for.
     * @return Returns the action for the state.
     */
    //public int GetAction(int state) {
       // return explorationPolicy.ChooseAction(qValues[state]);
    //}

    /**
     * Update Q-function's value for the previous state-action pair.
     *
     * @param previousState Previous state.
     * @param action        Action, which leads from previous to the next state.
     * @param reward        Reward value, received by taking specified action from previous state.
     * @param nextState     Next state.
     */
    public void UpdateState(int previousState, int action, double reward, int nextState) {
        // next state's action estimations
        double[] nextActionEstimations = qValues[nextState];
        // find maximum expected summary reward from the next state
        double maxNextExpectedReward = nextActionEstimations[0];

        for (int i = 1; i < actions; i++) {
            if (nextActionEstimations[i] > maxNextExpectedReward)
                maxNextExpectedReward = nextActionEstimations[i];
        }
        // previous state's action estimations
        double[] previousActionEstimations = qValues[previousState];
        // update expected summary reward of the previous state
        previousActionEstimations[action] *= (1.0 - learningRate);
        previousActionEstimations[action] += (learningRate * (reward + discountFactor * maxNextExpectedReward));
    }
}
