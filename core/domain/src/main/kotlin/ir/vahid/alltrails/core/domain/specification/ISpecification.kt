package ir.vahid.alltrails.core.domain.specification

interface ISpecification<T> {
    fun isSatisfiedBy(candidate: T): Boolean
}
