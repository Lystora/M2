method LinearSearch(a:array<int>, key:int) returns (r:int)
  requires a.Length > 0
  ensures 0 <= r ==> r < a.Length && a[r]==key
  ensures r < 0 ==> forall i :: 0 <= i < a.Length ==> a[i] != key
{
    var i := 0;
    while i < a.Length
    {
        if a[i] == key
        {
            r := i;
            return;
        }else{
           i := i + 1; 
        }
        
    }
    return -1;
}