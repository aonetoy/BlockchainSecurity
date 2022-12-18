pragma solidity^0.4.18;

library SafeMath {
  function mul(uint256 a, uint256 b) internal pure returns (uint256) {
    if (a == 0) {
      return 0;
    }
    uint256 c = a * b;
    assert(c / a == b);
    return c;
  }

  function div(uint256 a, uint256 b) internal pure returns (uint256) {
    uint256 c = a / b;
    return c;
  }

  function sub(uint256 a, uint256 b) internal pure returns (uint256) {
    uint256 c = a - b;
    assert(b <= a);
    return c;
  }

  function add(uint256 a, uint256 b) internal pure returns (uint256) {
    uint256 c = a + b;
    assert(c >= a);
    return c;
  }
}

contract OverUnderFlowSafe {
    using SafeMath for uint;
    uint public zero = 0;
    uint public max = 2**256-1;
    
    function underflow() {
        zero = zero.sub(1);
    }
    function overflow() public {
        max = max.add(1);
    }
}