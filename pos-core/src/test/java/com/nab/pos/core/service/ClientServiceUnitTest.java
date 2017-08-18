package com.nab.pos.core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.nab.pos.common.dto.ClientDTO;
import com.nab.pos.common.util.LoggerFactory;
import com.nab.pos.core.repository.ClientRepository;
import com.nab.pos.core.util.test.ClientRepositoryExpected;
import com.nab.pos.core.util.test.ClientRepositoryStub;

public class ClientServiceUnitTest {

  private Logger logger = LoggerFactory.getLogger(ClientServiceUnitTest.class);

  private ClientService service;

  private ClientRepository repositoryMock;

  private ClientRepositoryStub repositoryStub;

  @Before
  public void setUp() {

    repositoryStub = new ClientRepositoryStub();

    service = new ClientServiceImpl();

    repositoryMock = org.mockito.Mockito.mock(ClientRepository.class);

    ReflectionTestUtils.setField(service, "repository", repositoryMock);

    logger.info("Wow! I'm configured!");
  }

  @Test
  public void testList() {
    List<ClientDTO> expectedClientList = ClientRepositoryExpected.getExpectedClientList();

    org.mockito.Mockito.when(repositoryMock.list()).thenReturn(repositoryStub.list());

    List<ClientDTO> actualClientList = service.list();

    assertEquals(expectedClientList.size(), actualClientList.size());

  }

}
