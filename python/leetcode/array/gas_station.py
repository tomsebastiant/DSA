class M_GasStation:
    """
    LC: 134
    Tags: Greedy
    https://leetcode.com/problems/gas-station
    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
    to its next station. You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Approach: If total gas is less than total cost, the trip is impossible. Otherwise, reset the start
    whenever the running balance drops below zero.
    """

    def can_complete_circuit(self, gas, cost):
        total_gas = sum(gas)
        total_cost = sum(cost)
        if total_cost > total_gas:
            return -1

        start = 0
        balance = 0
        for i in range(len(gas)):
            balance += gas[i] - cost[i]
            if balance < 0:
                start = i + 1
                balance = 0
        return start

