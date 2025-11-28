package org.babyfish.jimmer.sql.example.model;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.Selection;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = Book.class
)
@PropsFor(Book.class)
public interface BookProps extends Props, Selection<Book> {
    TypedProp.Scalar<Book, Long> ID = 
        TypedProp.scalar(ImmutableType.get(Book.class).getProp("id"));

    TypedProp.Scalar<Book, String> NAME = 
        TypedProp.scalar(ImmutableType.get(Book.class).getProp("name"));

    TypedProp.Scalar<Book, Integer> EDITION = 
        TypedProp.scalar(ImmutableType.get(Book.class).getProp("edition"));

    TypedProp.Scalar<Book, BigDecimal> PRICE = 
        TypedProp.scalar(ImmutableType.get(Book.class).getProp("price"));

    TypedProp.Reference<Book, BookStore> STORE = 
        TypedProp.reference(ImmutableType.get(Book.class).getProp("store"));

    TypedProp.ReferenceList<Book, Author> AUTHORS = 
        TypedProp.referenceList(ImmutableType.get(Book.class).getProp("authors"));

    PropExpression.Num<Long> id();

    PropExpression.Str name();

    PropExpression.Num<Integer> edition();

    PropExpression.Num<BigDecimal> price();

    BookStoreTable store();

    BookStoreTable store(JoinType joinType);

    PropExpression.Num<Long> storeId();

    Predicate authors(Function<AuthorTableEx, Predicate> block);
}
