# Access Lab Description with MkDocs

The lab description is written with MkDocs.

* `mkdocs serve` - Start the live-reloading docs server.
* `mkdocs build` - Build the documentation site.
* `mkdocs -h` - Print help message and exit.

# Install MkDocs

See [MkDocs Installation Guide](https://www.mkdocs.org/user-guide/installation/).

## Prepare Installation on Ubuntu

### Install Python

```java
sudo apt-get install python3
```

### Install Pip

```java
sudo apt-get install pip
```

Check the installation:
```java
pip -V
```

## Prepare Installation on Windows

### Install Python and Pip

Use the windows installer [available here](https://www.python.org/downloads/release/python-3113/).

Check the installation:
```java
pip -V
```

## Install MkDocs

```java
pip install mkdocs
```

```java
pip install mkdocs-material
```

```java
pip install mkdocs-material-extensions
```

# Publish Lab Description Locally with MkDocs

1. mkdocs build
2. mkddocs serve
3. [Open in browser](http://127.0.0.1:8000/hexacleanws/)