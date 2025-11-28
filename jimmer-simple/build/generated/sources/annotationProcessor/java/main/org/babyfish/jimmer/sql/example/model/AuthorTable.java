package org.babyfish.jimmer.sql.example.model;

import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableOwner;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = Author.class
)
public class AuthorTable extends AbstractTypedTable<Author> implements AuthorProps {
    public static final AuthorTable $ = new AuthorTable();

    public AuthorTable() {
        super(Author.class);
    }

    public AuthorTable(AbstractTypedTable.DelayedOperation<Author> delayedOperation) {
        super(Author.class, delayedOperation);
    }

    public AuthorTable(TableImplementor<Author> table) {
        super(table);
    }

    protected AuthorTable(AuthorTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected AuthorTable(AuthorTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(AuthorProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str firstName() {
        return __get(AuthorProps.FIRST_NAME.unwrap());
    }

    @Override
    public PropExpression.Str lastName() {
        return __get(AuthorProps.LAST_NAME.unwrap());
    }

    @Override
    public PropExpression.Cmp<Gender> gender() {
        return __get(AuthorProps.GENDER.unwrap());
    }

    @Override
    public Predicate books(Function<BookTableEx, Predicate> block) {
        return exists(AuthorProps.BOOKS.unwrap(), block);
    }

    @Override
    public AuthorTableEx asTableEx() {
        return new AuthorTableEx(this, (String)null);
    }

    @Override
    public AuthorTable __disableJoin(String reason) {
        return new AuthorTable(this, reason);
    }

    @Override
    public AuthorTable __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new AuthorTable(this, baseTableOwner);
    }

    @GeneratedBy(
            type = Author.class
    )
    public static class Remote extends AbstractTypedTable<Author> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(Author.class, delayedOperation);
        }

        public Remote(TableImplementor<Author> table) {
            super(table);
        }

        public Remote(Remote base, BaseTableOwner baseTableOwner) {
            super(base, baseTableOwner);
        }

        public PropExpression.Num<Long> id() {
            return (org.babyfish.jimmer.sql.ast.PropExpression.Num<java.lang.Long>)this.<Long>get(AuthorProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<Author> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }

        @Override
        public Remote __baseTableOwner(BaseTableOwner baseTableOwner) {
            return new Remote(this, baseTableOwner);
        }
    }
}
