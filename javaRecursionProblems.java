/*Given an array of ints, is it possible to choose a group of some of the ints, 
such that the group sums to the given target? This is a classic backtracking 
recursion problem. Once you understand the recursive backtracking strategy in 
this problem, you can use the same pattern for many problems to search a space 
of choices. Rather than looking at the whole array, our convention is to consider 
the part of the array starting at index start and continuing to the end of the 
array. The caller can specify the whole array simply by passing start as 0. No 
loops are needed -- the recursive calls progress down the array. 
groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false
*/

public boolean groupSum(int start, int[] nums, int target) {
  if(start >= nums.length) return (target == 0);
  if(groupSum(start+1, nums, target-nums[start])) return true;
  if(groupSum(start+1, nums, target)) return true;
  return false;
}

/*
Given an array of ints, is it possible to choose a group of some of the ints, 
beginning at the start index, such that the group sums to the given target? 
However, with the additional constraint that all 6's must be chosen. (No loops needed.)

groupSum6(0, [5, 6, 2], 8) → true
groupSum6(0, [5, 6, 2], 9) → false
groupSum6(0, [5, 6, 2], 7) → false
*/

public boolean groupSum6(int start, int[] nums, int target) {
  if(start >= nums.length) return (target == 0);
  if(groupSum6(start+1, nums, target-nums[start])) return true;
  if(nums[start] == 6){
    if(groupSum6(start+1, nums, target-nums[start])) return true;
  }else{
  if(groupSum6(start+1, nums, target)) return true;
  }
  return false;
}


/*Given an array of ints, is it possible to choose a group of some of the ints, 
such that the group sums to the given target with this additional constraint: 
If a value in the array is chosen to be in the group, the value immediately 
following it in the array must not be chosen. (No loops needed.)

groupNoAdj(0, [2, 5, 10, 4], 12) → true
groupNoAdj(0, [2, 5, 10, 4], 14) → false
groupNoAdj(0, [2, 5, 10, 4], 7) → false
*/

public boolean groupNoAdj(int start, int[] nums, int target) {
  if(start >= nums.length) return (target == 0);
  if(groupNoAdj(start+2, nums, target-nums[start])) return true;
  if(groupNoAdj(start+1, nums, target)) return true;
  return false;
}

/*Given an array of ints, is it possible to choose a group of some of the 
ints, such that the group sums to the given target with these additional 
constraints: all multiples of 5 in the array must be included in the group. 
If the value immediately following a multiple of 5 is 1, it must not be 
chosen. (No loops needed.)

groupSum5(0, [2, 5, 10, 4], 19) → true
groupSum5(0, [2, 5, 10, 4], 17) → true
groupSum5(0, [2, 5, 10, 4], 12) → false
*/

public boolean groupSum5(int start, int[] nums, int target) {
  if(start >= nums.length) return (target == 0);
  if(nums[start] % 5 == 0){
    if(start+1 < nums.length && nums[start+1] == 1){
      return groupSum5(start+2, nums, target-nums[start]);
    }else{
      return groupSum5(start+1, nums, target-nums[start]);
    }
  }
  return groupSum5(start+1, nums, target-nums[start]) || groupSum5(start+1, nums, target);
}

/*
Given an array of ints, is it possible to choose a group of some of the 
ints, such that the group sums to the given target, with this additional 
constraint: if there are numbers in the array that are adjacent and the 
identical value, they must either all be chosen, or none of them chosen. 
For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in 
the middle must be chosen or not, all as a group. (one loop can be used 
to find the extent of the identical values).

groupSumClump(0, [2, 4, 8], 10) → true
groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
groupSumClump(0, [2, 4, 4, 8], 14) → false
*/

public boolean groupSumClump(int start, int[] nums, int target) {
  if(start >= nums.length) return (target == 0);
  
  if(start+1 < nums.length && nums[start] == nums[start+1]){
    int tally = 1;
    while(start+tally < nums.length && nums[start] == nums[start+tally]){
      tally++;
    }
    return groupSumClump(start+tally, nums, target - tally*nums[start]) || 
      groupSumClump(start+tally, nums, target);
  }
  
  return groupSumClump(start+1, nums, target-nums[start]) || 
    groupSumClump(start+1, nums, target);
}




