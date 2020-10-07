method BinarySearch_bis(a:array<int>, key:int) returns (r:int) 
    requires forall i,j :: 0 <= i < j < a.Length ==> a[i] <= a[j]
    ensures 0 <= r <= a.Length
    ensures r < a.Length ==> forall i,j :: 0 <= i < r <= j < a.Length ==> a[i] < key <= a[j]
    ensures r == a.Length ==> forall i :: 0 <= i < r ==> a[i] < key
{
    var lo, hi := 0, a.Length;
    while lo < hi 
        invariant 0 <= lo <= hi <= a.Length
        invariant forall i :: 0 <= i < lo ==> a[i] < key
        invariant forall i :: hi <= i < a.Length ==> key <= a[i] 
        decreases hi - lo
    {
        var mid := (lo + hi) / 2 ;
        if key < a[mid]{
            hi := mid ;
        }else if a[mid] < key{
            lo := mid + 1;
        }
    }
    return lo;
}