# Hello!

Hello World!

# Instruction

To run 

## Windows

To run cluster on Windows you need to follow THIS instruction **till** step _"KinD: Kubernetes made easy in a container"_. Basically you need to install [docker for windows](https://docs.docker.com/desktop/install/windows-install/), create WSL2 distro and enable WSL2 integration in Docker Desktop. You can also use [Chocolatey](https://chocolatey.org/install) to install docker and kind by running `choco install docker kind`

## Next steps


```shell
curl -Lo /tmp/kind https://kind.sigs.k8s.io/dl/v0.17.0/kind-linux-amd64
# Make the binary executable
chmod +x /tmp/kind
# Move the binary to your executable path
sudo mv /tmp/kind /usr/local/bin/
```

From here on, you can run those instructions (maybe with small adjustments) on any Linux/Windows distro.

```shell
kind create cluster --config cluster.yaml
```
