method SumMaxBackwards(s:int, m :int) returns (x:int, y:int)
    requires m >= s - m
    ensures s == x + y
    ensures x <= m && y <= m
    ensures m == x || m == y
{
    x := m ;
    y := s - x ;
}