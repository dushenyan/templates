package org.babyfish.jimmer.sql.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.OneToMany;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

@GeneratedBy(
        type = BookStore.class
)
public interface BookStoreDraft extends BookStore, Draft {
    BookStoreDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    BookStoreDraft setId(long id);

    @OldChain
    BookStoreDraft setName(String name);

    @OldChain
    BookStoreDraft setWebsite(String website);

    List<BookDraft> books(boolean autoCreate);

    @OldChain
    BookStoreDraft setBooks(List<Book> books);

    @OldChain
    BookStoreDraft addIntoBooks(DraftConsumer<BookDraft> block);

    @OldChain
    BookStoreDraft addIntoBooks(Book base, DraftConsumer<BookDraft> block);

    @GeneratedBy(
            type = BookStore.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_NAME = 1;

        public static final int SLOT_WEBSITE = 2;

        public static final int SLOT_BOOKS = 3;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.114",
                BookStore.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (BookStore)base)
            )
            .id(SLOT_ID, "id", long.class)
            .key(SLOT_NAME, "name", String.class, false)
            .add(SLOT_WEBSITE, "website", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_BOOKS, "books", OneToMany.class, Book.class, false)
            .build();

        private Producer() {
        }

        public BookStore produce(DraftConsumer<BookStoreDraft> block) {
            return (BookStore)Internal.produce(TYPE, null, block);
        }

        public BookStore produce(BookStore base, DraftConsumer<BookStoreDraft> block) {
            return (BookStore)Internal.produce(TYPE, base, block);
        }

        public BookStore produce(boolean resolveImmediately, DraftConsumer<BookStoreDraft> block) {
            return (BookStore)Internal.produce(TYPE, null, resolveImmediately, block);
        }

        public BookStore produce(BookStore base, boolean resolveImmediately,
                DraftConsumer<BookStoreDraft> block) {
            return (BookStore)Internal.produce(TYPE, base, resolveImmediately, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = BookStore.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "name", "website", "books"})
        public abstract static class Implementor implements BookStore, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_NAME:
                    		return name();
                    case SLOT_WEBSITE:
                    		return website();
                    case SLOT_BOOKS:
                    		return books();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "name":
                    		return name();
                    case "website":
                    		return website();
                    case "books":
                    		return books();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getName() {
                return name();
            }

            @Nullable
            public final String getWebsite() {
                return website();
            }

            public final List<Book> getBooks() {
                return books();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = BookStore.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __nameValue;

            String __websiteValue;

            boolean __websiteLoaded = false;

            NonSharedList<Book> __booksValue;

            @Override
            @JsonIgnore
            @Description("The surrogate id of the current object,\n"
                            + "auto-incrementing,\n"
                            + "without specific business meaning")
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(BookStore.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            @Description("The name of current BookStore.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint,\n"
                            + "which is {@code @Key} of Jimmer</p>")
            public String name() {
                if (__nameValue == null) {
                    throw new UnloadedException(BookStore.class, "name");
                }
                return __nameValue;
            }

            @Override
            @JsonIgnore
            @org.jspecify.annotations.Nullable
            public String website() {
                if (!__websiteLoaded) {
                    throw new UnloadedException(BookStore.class, "website");
                }
                return __websiteValue;
            }

            @Override
            @JsonIgnore
            @Description("All books belonging to the current bookstore,\n"
                            + "representing a one-to-many association")
            public List<Book> books() {
                if (__booksValue == null) {
                    throw new UnloadedException(BookStore.class, "books");
                }
                return __booksValue;
            }

            @Override
            public Impl clone() {
                try {
                    Impl copy = (Impl) super.clone();
                    Visibility originalVisibility = this.__visibility;
                    if (originalVisibility != null) {
                        Visibility newVisibility = Visibility.of(4);
                        for (int propId = 0; propId < 4; propId++) {
                            newVisibility.show(propId, originalVisibility.visible(propId));
                        }
                        copy.__visibility = newVisibility;
                    } else {
                        copy.__visibility = null;
                    }
                    return copy;
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_NAME:
                    		return __nameValue != null;
                    case SLOT_WEBSITE:
                    		return __websiteLoaded;
                    case SLOT_BOOKS:
                    		return __booksValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "name":
                    		return __nameValue != null;
                    case "website":
                    		return __websiteLoaded;
                    case "books":
                    		return __booksValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_NAME:
                    		return __visibility.visible(SLOT_NAME);
                    case SLOT_WEBSITE:
                    		return __visibility.visible(SLOT_WEBSITE);
                    case SLOT_BOOKS:
                    		return __visibility.visible(SLOT_BOOKS);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "name":
                    		return __visibility.visible(SLOT_NAME);
                    case "website":
                    		return __visibility.visible(SLOT_WEBSITE);
                    case "books":
                    		return __visibility.visible(SLOT_BOOKS);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__nameValue != null) {
                    hash = 31 * hash + __nameValue.hashCode();
                }
                if (__websiteLoaded && __websiteValue != null) {
                    hash = 31 * hash + __websiteValue.hashCode();
                }
                if (__booksValue != null) {
                    hash = 31 * hash + __booksValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__nameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__nameValue);
                }
                if (__websiteLoaded) {
                    hash = 31 * hash + System.identityHashCode(__websiteValue);
                }
                if (__booksValue != null) {
                    hash = 31 * hash + System.identityHashCode(__booksValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && !Objects.equals(__nameValue, __other.name())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_WEBSITE)) != __other.__isVisible(PropId.byIndex(SLOT_WEBSITE))) {
                    return false;
                }
                boolean __websiteLoaded = this.__websiteLoaded;
                if (__websiteLoaded != __other.__isLoaded(PropId.byIndex(SLOT_WEBSITE))) {
                    return false;
                }
                if (__websiteLoaded && !Objects.equals(__websiteValue, __other.website())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_BOOKS)) != __other.__isVisible(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                boolean __booksLoaded = __booksValue != null;
                if (__booksLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                if (__booksLoaded && !Objects.equals(__booksValue, __other.books())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && __nameValue != __other.name()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_WEBSITE)) != __other.__isVisible(PropId.byIndex(SLOT_WEBSITE))) {
                    return false;
                }
                boolean __websiteLoaded = this.__websiteLoaded;
                if (__websiteLoaded != __other.__isLoaded(PropId.byIndex(SLOT_WEBSITE))) {
                    return false;
                }
                if (__websiteLoaded && __websiteValue != __other.website()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_BOOKS)) != __other.__isVisible(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                boolean __booksLoaded = __booksValue != null;
                if (__booksLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                    return false;
                }
                if (__booksLoaded && __booksValue != __other.books()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = BookStore.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, BookStoreDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private BookStore __resolved;

            DraftImpl(DraftContext ctx, BookStore base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public BookStoreDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String name() {
                return (__modified!= null ? __modified : __base).name();
            }

            @Override
            public BookStoreDraft setName(String name) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (name == null) {
                    throw new IllegalArgumentException(
                        "'name' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__nameValue = name;
                return this;
            }

            @Override
            @JsonIgnore
            @org.jspecify.annotations.Nullable
            public String website() {
                return (__modified!= null ? __modified : __base).website();
            }

            @Override
            public BookStoreDraft setWebsite(String website) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__websiteValue = website;
                __tmpModified.__websiteLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public List<Book> books() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).books(), Book.class, true);
            }

            @Override
            public List<BookDraft> books(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_BOOKS)))) {
                    setBooks(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).books(), Book.class, true);
            }

            @Override
            public BookStoreDraft setBooks(List<Book> books) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (books == null) {
                    throw new IllegalArgumentException(
                        "'books' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__booksValue = NonSharedList.of(__tmpModified.__booksValue, books);
                return this;
            }

            @Override
            public BookStoreDraft addIntoBooks(DraftConsumer<BookDraft> block) {
                addIntoBooks(null, block);
                return this;
            }

            @Override
            public BookStoreDraft addIntoBooks(Book base, DraftConsumer<BookDraft> block) {
                books(true).add((BookDraft)BookDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_NAME:
                    		setName((String)value);break;
                    case SLOT_WEBSITE:
                    		setWebsite((String)value);break;
                    case SLOT_BOOKS:
                    		setBooks((List<Book>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "name":
                    		setName((String)value);break;
                    case "website":
                    		setWebsite((String)value);break;
                    case "books":
                    		setBooks((List<Book>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_NAME:
                    		__visibility.show(SLOT_NAME, visible);break;
                    case SLOT_WEBSITE:
                    		__visibility.show(SLOT_WEBSITE, visible);break;
                    case SLOT_BOOKS:
                    		__visibility.show(SLOT_BOOKS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "name":
                    		__visibility.show(SLOT_NAME, visible);break;
                    case "website":
                    		__visibility.show(SLOT_WEBSITE, visible);break;
                    case "books":
                    		__visibility.show(SLOT_BOOKS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_NAME:
                    		__modified().__nameValue = null;break;
                    case SLOT_WEBSITE:
                    		__modified().__websiteValue = null;
                    __modified().__websiteLoaded = false;break;
                    case SLOT_BOOKS:
                    		__modified().__booksValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "name":
                    		__modified().__nameValue = null;break;
                    case "website":
                    		__modified().__websiteValue = null;
                    __modified().__websiteLoaded = false;break;
                    case "books":
                    		__modified().__booksValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.BookStore\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_BOOKS))) {
                            List<Book> oldValue = base.books();
                            List<Book> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setBooks(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__booksValue = NonSharedList.of(__tmpModified.__booksValue, __ctx.resolveList(__tmpModified.__booksValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = BookStore.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            this(null);
        }

        public Builder(@org.jspecify.annotations.Nullable BookStore base) {
            __draft = new Producer.DraftImpl(null, base);
        }

        public Builder id(@NonNull Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder name(@NonNull String name) {
            if (name != null) {
                __draft.setName(name);
            }
            return this;
        }

        public Builder website(@org.jspecify.annotations.Nullable String website) {
            __draft.setWebsite(website);
            return this;
        }

        public Builder books(@NonNull List<Book> books) {
            if (books != null) {
                __draft.setBooks(books);
            }
            return this;
        }

        public BookStore build() {
            return (BookStore)__draft.__modified();
        }
    }
}
