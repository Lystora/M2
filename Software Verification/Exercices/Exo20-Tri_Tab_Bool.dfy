method tri_tab_bool(a: array<bool>)
    modifies a
    ensures forall m,n :: 0 <= m < n < a.Length ==> (!a[m] || a[n])
    ensures multiset(a[..]) == multiset(old(a[..]))
{
    var lo, hi := 0, a.Length - 1;
    while (lo < hi)
    invariant multiset(a[..]) == multiset(old(a[..]))
    {
        switch a[lo]

    }
}