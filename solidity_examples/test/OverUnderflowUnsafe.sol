pragma solidity^0.4.18;

contract OverUnderFlowUnsafe {
    uint public zero = 0;
    uint public max = 2**256-1;
    
    function underflow() public {
        zero -= 1;
    }
    function overflow() public {
        max += 1;
    }
}
